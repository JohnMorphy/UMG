const liElements = document.querySelectorAll("ul li");

let negativeCount = 0;
let positiveCount = 0;
let zeroCount = 0;

liElements.forEach(li => {
    const number = parseFloat(li.textContent);
    if (number < 0) {
        negativeCount++;
    } else if (number > 0) {
        positiveCount++;
    } else {
        zeroCount++;
    }
});

document.querySelector(".belowZero").textContent = `Negative: ${negativeCount}`;
document.querySelector(".aboveZero").textContent = `Positive: ${positiveCount}`;
document.querySelector(".zeros").textContent = `Zero: ${zeroCount}`;