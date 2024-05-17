"use strict";

function validate() {

    let fullName = document.getElementById("imienazwisko").value;
    let year = document.getElementById("rok").value;
    let indexNumber = document.getElementById("nrindeksu").value;

    var reg_name = new RegExp("^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+ [A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$");
    var reg_year = new RegExp("^(19\\d{2}|20(?:[0-1]\\d|20))$");
    var reg_indexNumber = new RegExp("^[A-Z][0-9]{5,6}$");

    if (!(reg_name.test(fullName))) {
        console.log("wrong name format");    
        document.getElementById("error_Message").innerHTML = "wrong name format";
        return false;
    }

    if (!(reg_year.test(year))) {
        console.log("wrong year format");    
        document.getElementById("error_Message").innerHTML = "wrong year format";
        return false;
    }

    if (!(reg_indexNumber.test(indexNumber))) {
        console.log("wrong index number");
        document.getElementById("error_Message").innerHTML = "wrong index format";    
        return false;
    }

    var yearDigitSum = 0;
    var value = parseInt(year, 10);
    while (value) {
        yearDigitSum += value % 10;
        value = Math.floor(value / 10);
    }
    var lastTwoCharacters = indexNumber.slice(-2);
    var lastTwoNumbers = parseInt(lastTwoCharacters, 10);
    
    if(lastTwoNumbers != yearDigitSum) {
        console.log("wrong index number");
        document.getElementById("error_Message").innerHTML = "wrong index format";    
        return false;
    }
    

    document.getElementById("error_Message").innerHTML = "";      
    return true;
}