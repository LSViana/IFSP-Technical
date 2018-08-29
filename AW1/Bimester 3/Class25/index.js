function getExerciseElement(number, identifier) {
  return document.getElementById("ex" + number + "." + identifier);
}

function saveUserName(name) {
  localStorage.setItem("userName", name);
}

function getUserName() {
  return localStorage.getItem("userName");
}

function removeUserName() {
  localStorage.removeItem("userName");
}

function getTimeMessageExercise1() {
  let date = new Date();
  let hour = date.getHours();
  if (hour < 12)
    return "Good morning";
  else if (hour < 19)
    return "Good afternoon";
  return "Good evening";
}

function getSchoolMessageExercise2() {
  let date = new Date();
  let hour = date.getHours();
  let minute = date.getMinutes();
  let message = "Hey, ";
  let userName = getUserName();
  if (userName) {
    message = userName + ", ";
  }
  if (hour == 7 || (hour == 13 && minute == 15)) {
    message += "let's go to classes!";
  } else if ((hour == 9 && minute == 15) || (hour == 15 && minute == 30)) {
    message += "RECREIO's time!";
  } else if ((hour == 11 && minute == 45) || hour == 18) {
    message += "classes are over, let's leave!";
    // This test shouldn't be there
  } else if (hour == 10 && minute == 46) {
    message += "it's a test for the current time.";
  } else
    message += "how is your day going?";
  return message;
}

function getRandomNumber(length) {
  let result = "";
  for (let i = 0; i < length; i++) {
    result += Math.round(Math.random() * 9);
  }
  return result;
}

function getVerifierDigit(partialCPF) {
  let multipliers = [];
  for (let i = partialCPF.length + 1; i >= 2; i--) {
    multipliers.push(i);
  }
  let values = [];
  for (let i = 0; i < multipliers.length; i++) {
    values.push(multipliers[i] * Number(partialCPF[i]));
  }
  let sumOfValues = values.reduce((previous, current) => previous + current, 0);
  let modByEleven = sumOfValues % 11;
  if (modByEleven < 2)
    return 0;
  return 11 - modByEleven;
}

function getFullCPF(partialCPF) {
  let firstDigit = getVerifierDigit(partialCPF);
  partialCPF += firstDigit;
  let secondDigit = getVerifierDigit(partialCPF);
  partialCPF += secondDigit;
  // Now it is already complete! :)
  return partialCPF;
}

function getTableRow(columns) {
  let tr = document.createElement("tr");
  tr.rowData = [];
  for (let i = 0; i < columns; i++) {
    let td = document.createElement("td");
    td.innerText = "-";
    tr.rowData.push(td);
    tr.appendChild(td);
  }
  return tr;
}

function updateExercise1() {
  let message = getExerciseElement(1, "message");
  message.innerText = getTimeMessageExercise1();
  let userName = getUserName();
  if (userName) {
    message.innerText += ", " + userName;
  }
  message.innerText += "!";
}

function updateExercise2() {
  let message = getExerciseElement(2, "message");
  message.innerText = getSchoolMessageExercise2();
}

function updateExercise3() {
  let cpfSpan = getExerciseElement(3, "cpf");
  let randomPart = getRandomNumber(9);
  let cpf = getFullCPF(randomPart);
  cpfSpan.innerText = cpf;
}

function updateExercise4() {
  let cpfInput = getExerciseElement(4, "cpf");
  let button = getExerciseElement(4, "button");
  let answerSpan = getExerciseElement(4, "answer");
  button.addEventListener("click", () => {
    if (cpfInput.checkValidity()) {
      let firstPartCPF = cpfInput.value.substr(0, 9);
      let cpf = getFullCPF(firstPartCPF);
      if (cpf == cpfInput.value) {
        answerSpan.innerText = "Valid";
      } else {
        answerSpan.innerText = "Invalid";
      }
    } else {
      answerSpan.innerText = cpfInput.validationMessage + " [11 digits only]";
    }
  });
}

const dependentDeductionValue = 189.59;

function getINSSValue(salary, dependentsAmount) {
  let result = 0;
  if (salary < 1693.72)
    result = salary * 0.08;
  else if (salary < 2822.90)
    result = salary * 0.09;
  else if (salary < 5645.80)
    result = salary * 0.11;
  result = 621.04;
  result -= dependentsAmount * dependentDeductionValue;
  if (result < 0)
    result = 0;
  return result;
}

function getINSSRangeLabel(salary, dependentsAmount) {
  if (salary < 1693.72)
    return "8%";
  else if (salary < 2822.90)
    return "9%";
  else if (salary < 5645.80)
    return "11%";
  return "Ceiling";
}

function getIRRFValue(baseIRRF) {
  if (baseIRRF < 1903.98)
    return 0;
  else if (baseIRRF < 2826.65)
    return baseIRRF * 0.075 - 142.80;
  else if (baseIRRF < 3751.05)
    return baseIRRF * 0.15 - 354.80;
  else if (baseIRRF < 4664.68)
    return baseIRRF * 0.225 - 636.13;
  return baseIRRF * 0.275 - 869.36;
}

function getIRRFRangeLabel(baseIRRF) {
  if (baseIRRF < 1903.98)
    return "0%";
  else if (baseIRRF < 2826.65)
    return "7.5%";
  else if (baseIRRF < 3751.05)
    return "15%";
  else if (baseIRRF < 4664.68)
    return "22.5%";
  return "27.5%";
}

function updateExercise5() {
  let totalSalaryInput = getExerciseElement(5, "salary");
  let dependentsInput = getExerciseElement(5, "dependents");
  let otherChargesInput = getExerciseElement(5, "othercharges");
  let tbody = getExerciseElement(5, "tbody");
  let button = getExerciseElement(5, "button");
  //
  button.addEventListener("click", () => {
    // Calculus
    let inss = getINSSValue(totalSalaryInput.value, dependentsInput.value);
    let baseIRRF = totalSalaryInput.value - inss;
    let irrf = getIRRFValue(baseIRRF);
    let liquid = totalSalaryInput.value - inss - irrf - otherChargesInput.value;
    // Filling table
    let totalSalaryRow = getTableRow(4);
    let inssRow = getTableRow(4);
    let irrfRow = getTableRow(4);
    let otherChargesRow = getTableRow(4);
    let totalRow = getTableRow(4);
    let liquidRow = getTableRow(4);
    //
    totalSalaryRow.rowData[0].innerText = "Total Salary";
    totalSalaryRow.rowData[2].innerText = totalSalaryInput.value;
    inssRow.rowData[0].innerText = "INSS";
    inssRow.rowData[1].innerText = getINSSRangeLabel(totalSalaryInput.value, dependentsInput.value);
    inssRow.rowData[3].innerText = inss;
    irrfRow.rowData[0].innerText = "IRRF";
    irrfRow.rowData[1].innerText = getIRRFRangeLabel(baseIRRF);
    irrfRow.rowData[3].innerText = irrf;
    otherChargesRow.rowData[3].innerText = otherChargesInput.value;
    totalRow.rowData[0].innerText = "Total";
    totalRow.rowData[1].innerText = totalSalaryInput.value;
    let totalCharges = irrf + inss + otherChargesInput.value;
    totalRow.rowData[3].innerText = totalCharges;
    liquidRow.rowData[0].innerText = "Liquid Salary";
    liquidRow.rowData[3].innerText = totalSalaryInput.value - totalCharges;
    //
    tbody.appendChild(totalSalaryRow);
    tbody.appendChild(inssRow);
    tbody.appendChild(irrfRow);
    tbody.appendChild(otherChargesRow);
    tbody.appendChild(totalRow);
    tbody.appendChild(liquidRow);
  });
  button.dispatchEvent(new MouseEvent("click"));
}

function configureExercises() {
  let inputName = getExerciseElement(1, "name");
  inputName.addEventListener("blur", () => {
    let freshName = inputName.value;
    if (freshName)
      saveUserName(freshName);
    else
      removeUserName();
    updateExercise2();
    updateExercise1();
  });
  let userName = getUserName();
  if (userName) {
    inputName.value = userName;
  }
  updateExercise1();
  updateExercise2();
  updateExercise3();
  updateExercise4();
  updateExercise5();
}

window.addEventListener("load", () => {
  configureExercises();
});