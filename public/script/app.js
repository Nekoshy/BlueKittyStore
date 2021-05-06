const contactForm = document.querySelector('.contact__form');

let name = document.getElementById('name');
let email = document.getElementById('email');
let subject = document.getElementById('subject');
let message = document.getElementById('message');

contactForm.addEventListener('submit', (e) => {
    e.preventDefault();

    let formData = {
        name: name.value,
        subject: subject.value,
        email: email.value,
        message: message.value
    }

    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/contact.html');
    xhr.setRequestHeader('content-type', 'application/json');
    xhr.onload = function() {
        console.log(xhr.responseText);
        if(xhr.responseText == 'success'){
            alert('Email sent');
            name.value = '';
            subject.value = '';
            email.value = '';
            message.value = '';
        }else{
            alert('Something went wrong!');
        }
    }

    xhr.send(JSON.stringify(formData));
});