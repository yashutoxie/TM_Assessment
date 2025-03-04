let inputA = document.createElement("input");
inputA.type = "number";
inputA.placeholder = "Enter number A";
document.querySelector('.calculator-container').appendChild(inputA);

let inputB = document.createElement("input");
inputB.type = "number";
inputB.placeholder = "Enter number B";
document.querySelector('.calculator-container').appendChild(inputB);

let operation = document.createElement("input");
operation.type = "text";
operation.placeholder = "Enter operation (+, -, *, /)";
document.querySelector('.calculator-container').appendChild(operation);


let button = document.createElement("button");
button.textContent = "Calculate";
document.querySelector('.calculator-container').appendChild(button);


let resultField = document.createElement("input");
resultField.type = "text";
resultField.placeholder = "Result";
resultField.readOnly = true;
resultField.classList.add('result-field');
document.querySelector('.calculator-container').appendChild(resultField);

button.addEventListener("click", function () {
    let a = parseFloat(inputA.value) || 0;
    let b = parseFloat(inputB.value) || 0;
    let op = operation.value.trim();
    let result;

    switch (op) {
        case "+":
            result = a + b;
            break;
        case "-":
            result = a - b;
            break;
        case "*":
            result = a * b;
            break;
        case "/":
            result = b !== 0 ? a / b : "Error: Divide by Zero";
            break;
        default:
            result = "Invalid operation";
    }

    resultField.value = result;
}); 
