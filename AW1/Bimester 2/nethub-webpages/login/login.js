var inputs = document.querySelectorAll("form div input, form div select");
inputs.forEach((value, index) => {
    value.setAttribute("value", "");
    value.oninput = () => {
        value.setAttribute("value", value.value);
    };
});


var loginButton = document.querySelector('#send-button');

loginButton.onclick = () =>{
    console.log("pesado");
    window.location.href = '../profile/profile.html';
};