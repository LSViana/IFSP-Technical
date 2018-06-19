var inputs = document.querySelectorAll("form div input, form div select");
inputs.forEach((value, index) => {
    value.setAttribute("value", "");
    value.oninput = () => {
        value.setAttribute("value", value.value);
    };
});


var signUpButton = document.querySelector('#send-button');

signUpButton.onclick = () =>{
    window.location.href = '../profile/profile.html';
};

var loginButton = document.querySelector("#login-button");
loginButton.addEventListener("click", function() {
    window.location.href = "../login/login.html";
});