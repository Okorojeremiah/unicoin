import React from "react";
import Login from "./Login";

function Home(){
    return (
        <div class="container">
            <div class="side left">
                <h1>Digital Wallet</h1>
                <h1>Crypto Coin</h1>
                <p>Based On High Demand</p>
                <button type="button" class="btns">Sign Up</button>
                <button type="button" class="btn">Log in</button>
            </div>
            <div class="side right">
                <Login />
            </div>
      </div>
    )

}

export default Home
