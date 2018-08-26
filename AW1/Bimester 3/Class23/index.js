// Constant definitions
const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];

function validateEx01() {
  let input = document.querySelector("#number1");
  if(input.checkValidity()) {
    alert("Valid value");
  } else {
    alert("Invalid value, try again!");
  }
}

function splitDateEx02() {
  let input = document.querySelector("#date2");
  if(input.checkValidity()) {
    let fullDateStr = input.value;
    let dateParts = fullDateStr.split("/");
    let result2 = document.querySelector("#result2");
    result2.innerText = `${monthNames[dateParts[0] - 1]} ${dateParts[1]}, ${dateParts[2]}`;
  } else {
    alert("Invalid date, use pattern [dd/MM/yyyy]");
  }
}

window.addEventListener("load", () => {
  let btnEx01 = document.querySelector("#ex-01 form button");
  btnEx01.addEventListener("click", validateEx01);
  //
  let btnEx02 = document.querySelector("#ex-02 form button");
  btnEx02.addEventListener("click", splitDateEx02);
});