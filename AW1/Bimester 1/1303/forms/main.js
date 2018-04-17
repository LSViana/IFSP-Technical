window.onload = () => {
    const postalCode_server = "https://viacep.com.br/"
    const postalCode_prefix = "ws/";
    const postalCode_suffix = "/json";
    const inputState = "inputState";
    // Setting up Inputs
    var dataState = document.querySelector("[data-state]");
    var dataCity = document.querySelector("[data-city]");
    var dataStreet = document.querySelector("[data-street]");
    var userInputs = document.querySelectorAll("input, select");
    userInputs.forEach((value, index, list) => {
        let valueAttr = "";
        if (value.tagName.toLowerCase() == "select") {
            if (value.childElementCount > 0) {
                valueAttr = value.children[0].getAttribute("value");
            }
        }
        else if(value.getAttribute("type").toLowerCase() == "date") {
            var date = new Date();
            value.setAttribute("max", date.toISOString().substr(0, 10));
            date.setHours(date.getHours() - 24);
            valueAttr = date.toISOString().substr(0, 10);
        }
        value.setAttribute("value", valueAttr);
        value.oninput = (ev) => {
            value.setAttribute("value", value.value);
        };
    });
    // CEP to Fill Address
    var inputPostalCode = document.getElementById("inputPostalCode");
    // Getting regex to Postal Code
    var regexp = new RegExp("[0-9]{8}");
    //
    inputPostalCode.onblur = () => {
        let postalCode = inputPostalCode.getAttribute("value").toString();
        if(regexp.test(postalCode) && postalCode.length == 8) {
            let postalCode_url = postalCode_server + postalCode_prefix + postalCode + postalCode_suffix;   
            fetch(postalCode_url)
                .then((res) => {
                    res.json()
                        .then((data) => {
                            let city = data.localidade.toString();
                            let state = data.uf.toString().toUpperCase();
                            let street = data.logradouro.toString();
                            setAttributeValue(dataState, "value", state);
                            setAttributeValue(dataCity, "value", city);
                            setAttributeValue(dataStreet, "value", street);
                        });
                })
                .catch((err) => {
                    console.log(err);                    
                });
        }
    };

    function setAttributeValue(element, attribute, value) {
        element.setAttribute(attribute, value);
        element[attribute] = value;
    }
    // dataElements.forEach((value, index, list) => {
    //     value.setAttribute("disabled", null);
    // });
}