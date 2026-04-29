function viewAccount() {
    let id = document.getElementById("viewAcc").value;

    fetch(`http://localhost:8080/bank/account/${id}`)
    .then(res => res.json())
    .then(data => {
        if (!data) {
            document.getElementById("output").innerText = "Account Not Found";
            return;
        }

        document.getElementById("output").innerText =
            "Account No: " + data.accountNumber +
            ", Name: " + data.holderName +
            ", Balance: " + data.balance;
    })
    .catch(err => console.log(err));
}