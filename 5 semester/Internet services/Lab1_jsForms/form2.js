"use strict";

const discountCheckbox = document.getElementById("discountCheckbox");
const normalCheckbox = document.getElementById("normalCheckbox");
const discountAmount = document.getElementById("idileulg");
const normalAmount = document.getElementById("idilenor");

discountCheckbox.addEventListener("change", function() {
    if (discountCheckbox.checked) {
        document.getElementById("idileulg").style.display = "block";
        document.getElementById("idilenag").style.display = "block";
    } else {
        document.getElementById("idileulg").value = "";
        document.getElementById("idileulg").style.display = "none";

        if(!(normalCheckbox.checked)) {
            document.getElementById("idilenag").style.display = "none";   
        }

    }
});

normalCheckbox.addEventListener("change", function() {
    if (normalCheckbox.checked) {
        document.getElementById("idilenor").style.display = "block";
        document.getElementById("idilenag").style.display = "block";
    } else {
        document.getElementById("idilenor").value = "";
        document.getElementById("idilenor").style.display = "none";

        if(!(discountCheckbox.checked)) {
            document.getElementById("idilenag").style.display = "none";   
        }
    }
});


discountAmount.addEventListener("input", function() {
    var inputValue = discountAmount.value;
    
    if (inputValue !== "") {
        document.getElementById("idwyslij").style.display = "block";
    } else if (normalAmount.value === "") {
        document.getElementById("idwyslij").style.display = "none";
    }
});

normalAmount.addEventListener("input", function() {
    var inputValue = normalAmount.value;
    
    if (inputValue !== "") {
        document.getElementById("idwyslij").style.display = "block";
    } else if (discountAmount.value === "") {
        document.getElementById("idwyslij").style.display = "none";
    }
});

function validate() {

    var reg = new RegExp("^\d+$");

    if(!(reg.test(discountAmount.value) && reg.test(normalAmount.value))) {
        return false;
    }

    return true;


}