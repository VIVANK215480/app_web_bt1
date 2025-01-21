function calculate() {
    const num1 = parseFloat(document.getElementById("num1").value);
    const operator = document.getElementById("operator").value;
    const num2 = parseFloat(document.getElementById("num2").value);

    if (isNaN(num1) || isNaN(num2)) {
        alert("Vui lòng nhập đúng các số!");
        return;
    }

    // Gọi hàm Java từ JavaScript
    const result = Android.calculate(operator, num1, num2);
    document.getElementById("result").innerText = result;
}
