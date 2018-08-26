const monthNames = [
  "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
];

window.exercise1 = function(ev, i) {
  let input = document.getElementById("ex" + i + ".number");
  let answer = document.getElementById("ex" + i + ".answer");
  if(input.checkValidity()) {
    answer.innerText = "Valid";
  } else {
    answer.innerText = input.validationMessage;
  }
}

window.exercise2 = function(ev, i) {
  let input = document.getElementById("ex" + i + ".number");
  let answer = document.getElementById("ex" + i + ".answer");
  if(input.checkValidity()) {
    answer.innerText = "";
    //
    let dateParts = input.value.split("/");
    let day = dateParts[0];
    let month = dateParts[1];
    let year = dateParts[2];
    if((day < 0 || day > 31) || (month < 0 || month > 12) || (year < 0)) {
      answer.innerText = "Invalid values";
    } else {
      answer.innerText = monthNames[month - 1] + " " + day + ", " + year;
    }
  } else {
    answer.innerText = "Date must follow the pattern 'dd/MM/yyyy'";
  }
}

function getBMIDescription(bmi, genre) {
  if(genre == "masculine") {
    if(bmi < 20.7)
      return "Less than ideal";
    else if(bmi < 26.4)
      return "Ideal";
    return "More than ideal";
  } else {
    if(bmi < 19)
      return "Less than ideal";
    else if(bmi < 25.8)
      return "Ideal";
    return "More than ideal";
  }
}

window.exercise3 = function(ev, i) {
  let genre = document.getElementById("ex" + i + ".genre");
  let mass = Number(document.getElementById("ex" + i + ".mass").value);
  let height = Number(document.getElementById("ex" + i + ".height").value);
  let bmi = mass / (Math.pow(height, 2));
  let answer = document.getElementById("ex" + i + ".answer");
  answer.innerText = "BMI: " + (Math.round(bmi * 100) / 100) + " – " + getBMIDescription(bmi, genre.value);
}

window.exercise4 = function(ev, i) {
  let cpf = document.getElementById("ex" + i + ".cpf").value;
  let answer = document.getElementById("ex" + i + ".answer");
  answer.innerText = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
}

function getTableRow(columns) {
  let tr = document.createElement("tr");
  tr.rowData = [];
  for(let i = 0; i < columns; i++) {
    let td = document.createElement("td");
    td.innerText = "-";
    tr.appendChild(td);
    tr.rowData.push(td);
  }
  return tr;
}

function roundNumber(value, places = 2) {
  return Math.round(value * Math.pow(10, places)) / Math.pow(10, places);
}

window.exercise5 = function(ev, i) {
  let loanTotal = Number(document.getElementById("ex" + i + ".loan").value);
  let loan = loanTotal;
  let installments = Number(document.getElementById("ex" + i + ".installments").value);
  let interest = Number(document.getElementById("ex" + i + ".interest").value);
  let tbody = document.getElementById("ex" + i + ".tbody");
  let installment = loan / installments;
  let columns = 5;
  let month = 0;
  // Clear the table
  tbody.innerHTML = "";
  // Create first line
  let firstRow = getTableRow(columns);
  tbody.appendChild(firstRow);
  firstRow.rowData[0].innerText = roundNumber(month);
  firstRow.rowData[1].innerText = roundNumber(loan);
  // Create installment lines
  let totalAmortization = 0;
  let totalInterest = 0;
  let totalInstallments = 0;
  month++;
  for(; month <= installments; month++) {
    let midRow = getTableRow(columns);
    midRow.rowData[0].innerText = roundNumber(month);
    midRow.rowData[1].innerText = roundNumber((loan - installment));
    midRow.rowData[2].innerText = roundNumber(installment);
    let monthInterest = loan * (interest / 100);
    midRow.rowData[3].innerText = roundNumber(monthInterest);
    let monthInstallment = installment + monthInterest;
    midRow.rowData[4].innerText = roundNumber(monthInstallment);
    //
    tbody.appendChild(midRow);
    //
    totalAmortization += installment;
    totalInterest += monthInterest;
    totalInstallments += monthInstallment;
    loan -= installment;
  }
  // Create last line
  let lastRow = getTableRow(columns);
  lastRow.rowData[0].innerText = "Total";
  lastRow.rowData[2].innerText = roundNumber(totalAmortization);
  lastRow.rowData[3].innerText = roundNumber(totalInterest);
  lastRow.rowData[4].innerText = roundNumber(totalInstallments);
  //
  tbody.appendChild(lastRow);
}

window.addEventListener("load", () => {
  let inputAmount = 5;
  for(let i = 1; i <= inputAmount; i++) {
    let buttonEx = document.getElementById("ex" + i + ".button");
    buttonEx.addEventListener("click", (ev) => {
      window["exercise" + i](ev, i);
    });
  }
});