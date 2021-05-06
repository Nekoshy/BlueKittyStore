process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = 0;

const express = require('express');
const app = express();

const nodemailer = require("nodemailer");


const PORT = process.env.PORT || 5000;

app.use(express.static(__dirname + '/public'));
app.use(express.json());

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/main/index.html');
});

app.get('/index.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/index.html');
});

app.get('/about.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/about.html');
});

app.get('/contact.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/contact.html');
});

app.get('/item.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/item.html');
});

app.get('/koszyk.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/koszyk.html');
});

app.get('/podsumowanie.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/podsumowanie.html');
});

app.get('/store.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/store.html');
});

app.get('/zamowienie.html', (req, res) => {
    res.sendFile(__dirname + '/public/main/zamowienie.html');
});

app.post('/contact.html', (req, res) => {
    console.log(req.body);

    const transporter = nodemailer.createTransport({
        service: 'gmail',
        auth: {
            user: 'storebluekitty@gmail.com',
            pass: 'password01!'
        }
    });

    const mailOptions = {
        from: req.body.email,
        to: 'storebluekitty@gmail.com',
        subject: `Message from ${req.body.email}: ${req.body.subject}`,
        text: req.body.message
    }

    transporter.sendMail(mailOptions, (error, info) => {
        if (error){
            console.log(error);
            res.send('error');
        }else{
            console.log('Email sent: ' + info.response);
            res.send('success')
        }
    })
})

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
})