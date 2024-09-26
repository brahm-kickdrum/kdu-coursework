const socket = io("http://localhost:3000");

window.addEventListener("load", function() { 
    const companyData = fetch('http://localhost:3000/')
    .then(response => response.json())
    .then(userData => {
        const company = this.document.getElementsByClassName("company-name");
        company.innerText = userData.name;
        const price = this.document.getElementsByClassName("price-value");
        price.innerText = userData.price;
        const percent = this.document.getElementsByClassName("percent");
        price.innerText = userData.percent;
        console.log('User Data:', userData);
    })
    .catch(error => {
        console.error('Error:', error);
    });

   
    

  });

  const buy = document.getElementsByClassName("buy");
  buy.addEventListener("click",buyStock);

  function buyStock(){
    const quantity = document.getElementsByClassName("enter-quantity").value;
    const buyStocks = document.getElementsByClassName("stock-quantity");
    buyStocks.innerText = quantity;
    const buyText = document.getElementsByClassName("buy-or-sell");
    buyText.innerText = "Buy";
    
  }

  const sell = document.getElementsByClassName("sell");
  buy.addEventListener("click",sellStock);

  function sellStock(){
    const quantity = document.getElementsByClassName("enter-quantity").value;
    const buyStocks = document.getElementsByClassName("stock-quantity");
    buyStocks.innerText = quantity;
    const buyText = document.getElementsByClassName("buy-or-sell");
    buyText.innerText = "Sell";
    
  }







