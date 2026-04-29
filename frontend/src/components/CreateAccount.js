function createAccount() {
    fetch("http://localhost:8080/bank/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            accountNumber: parseInt(document.getElementById("accNo").value),
            holderName: document.getElementById("name").value,
            balance: parseFloat(document.getElementById("balance").value)
        })
    })
    .then(res => res.text())
    .then(data => document.getElementById("output").innerText = data)
    .catch(err => console.log(err));
}