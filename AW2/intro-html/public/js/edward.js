window.addEventListener("load", async () => {
    // HTML Elements
    let dogsHelped = document.querySelector("#dogs-helped");
    let result = await fetch("https://dog.ceo/api/breeds/list/all");
    let jsonBreeds = await result.json();
    // Taking 10 random images
    let breedCounter = 0;
    for(let prop in jsonBreeds.message) {
        if(breedCounter > 10)
            break;
        if(Math.random() > .5) {
            // Getting the images from the breed
            let imageResponse = await fetch(`https://dog.ceo/api/breed/${prop}/images/random/1`)
            let image = (await imageResponse.json()).message[0];
            // Append the element in the dogs helped container
            let formattedBreed = prop;
            formattedBreed = formattedBreed[0].toUpperCase() + formattedBreed.slice(1);
            dogsHelped.innerHTML += `<article class="dog-helped">
            <h3>
                ${formattedBreed}
            </h3>
            <div class="dog-info">
                <div>
                    <p>Tamanho: </p>
                    <p>${Math.round(Math.random() * 30) / 10 + 2} cm</p>
                </div>
                <div>
                    <p>Peso: </p>
                    <p>${Math.round(Math.random() * 50) / 10 + 5} kg</p>
                </div>
            </div>
            <div class="image-container">
                <img src="${image}" alt="Dog helped in Edward's Friend Institute">
            </div>
        </article>`;
            // Incremeting the breeds shown
            breedCounter++;
        }
    }
});