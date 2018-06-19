document.querySelectorAll('#info .item label').forEach(label => {
    var input = document.querySelector('#' + label.getAttribute('for'));




    input.value = "";

    input.oninput = () => {
        input.setAttribute('value', input.value);

    };

    if (input.id !== 'bioinfo') {

        input.onfocus = () => {
            label.classList.add('focus-input');

        };
    } else {
        input.onfocus = () => {
            label.classList.add('focus-text-area');
            console.log('A');
        };
    }

    if (input.id !== 'bioinfo') {
        input.addEventListener('focusout', () => {

            if (input.value === "") {
                label.classList.remove('focus-input');
            }
        });
    }else {
        input.addEventListener('focusout',() => {
            if (input.value === "") {
                label.classList.remove('focus-text-area');
            }

        });
    }
});


var passwordConfirm = document.querySelector('#password-confirm');

passwordConfirm.disabled = 'disabled';

var password = document.querySelector('#password');

password.oninput = () => {
    passwordConfirm.removeAttribute('disabled');
    if (password.value === "") {
        console.log('a');
        passwordConfirm.value = "";
        passwordConfirm.disabled = 'disabled';

        return;
    }

}
passwordConfirm.addEventListener('focusout', function () {
    if (passwordConfirm.value !== password.value) {
        passwordConfirm.classList.add('incorrect');
    } else {
        passwordConfirm.classList.remove('incorrect');
    }
});
