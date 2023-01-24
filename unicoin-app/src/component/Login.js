import React, { useState } from 'react';
import PropTypes from 'prop-types';

async function loginUser(credentials) {
  return fetch('https://www.mecallapi.com/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(credentials)
  })
    .then(data => data.json())
  }

function Login({setToken}) {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

    const handleSubmit = async e => {
    e.preventDefault();
    const response = await loginUser({
      email,
      password
    })
    setToken(token);
  }

  return(
    <div className="form-group">
      <form className="form" onSubmit={handleSubmit}>
        <label>Email</label>
          <input 
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            />
        <labe>Password</labe>
          <input type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          
          />   
          <div>
          <button
          type='submit'
          value={email}
          onClick={handleSubmit}
          >
          Submit</button>   
          </div>
      </form>
      
    </div>
  )

}

Login.propTypes = {
  setToken: PropTypes.func.isRequired
}

export default Login
