const API_URL = "http://localhost:8080/api/meals"; //backend-API's adress

function addMeal() {
    const name = document.getElementById("name").value;
    const calories = document.getElementById("calories").value;
    const mealType = document.getElementById("mealType").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            calories: calories,
            mealType: mealType
        })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerText =
                "Tillagt: " + data.name + " (" + data.calories + " kcal)";
        })
}

function getMealTotal(mealType) {
    fetch(API_URL + "/total/" + mealType)
        .then(response => response.text())
        .then(total => {
            document.getElementById("result").innerText =
                "Totalt idag : " + total + " kcal";
        })
}