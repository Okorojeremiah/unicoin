import React from "react";

function TopNav(){
    return(
        <div className="navigation">
            <ul>
                <li><a class="active" href="#home">UniCoin</a></li>
                <li className="navs"><a className="navs" href="#about">About</a></li>
                <div className="reg-login">
                    <li className="navLogin"><a className="navLogin" href="#login">Login</a></li>
                    <li className="navReg"><a className="navReg" href="#register">Register</a></li>                    
                </div>
            </ul>
        </div>
    )
}

export default TopNav