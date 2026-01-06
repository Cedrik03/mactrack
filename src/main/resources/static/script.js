const API_URL = "http://localhost:8080/api/meals"; //backend-API's adress

document.getElementById('addMealButton').addEventListener('click', addMeal);

function addMeal() {
    const name = document.getElementById("name").value;
    const calories = document.getElementById("calories").value;
    const mealType = document.getElementById("mealType").value;

    if(!name || !calories || !mealType) {
        alert("Fyll i alla fält tack!");
        return;
    }

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

            document.getElementById("name").value = '';
            document.getElementById("calories").value = '';
        })

}

function getMealTotal(mealType) {

    const url = mealType ? `${API_URL}/total/${mealType}` : `${API_URL}/total`;

    fetch(url)
        .then(response => response.text())
        .then(total => {
                document.getElementById("result").innerText =
                    mealType
                        ? `Totalt för ${mealType.toLowerCase()}: ${total} kcal`
                        : `Totalt idag: ${total} kcal`;
        })
        .catch(err => {
            console.error(err);
            alert("Något gick fel vid hämtning av totalsumma!");
        });
}