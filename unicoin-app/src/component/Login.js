import React, { useState } from 'react';


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

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

    const handleSubmit = async e => {
    e.preventDefault();
    const response = await loginUser({
      email,
      password
    })
  }

  return(
    <div className="form-group">
      <form className="form">
        <label>Email</label>
          <input 
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            />
        <labe>Password</labe>
          <input type="text"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          
          />   
      </form>
      <button
        type='submit'
        value={email}
        onClick={handleSubmit}
      
        >Submit</button>   
    </div>
  )

}

export default Login

// export default function Login() {
//   const [email, setEmail] = useState();
//   const [password, setPassword] = useState();

//   const handleSubmit = async e => {
//     e.preventDefault();
//     const response = await loginUser({
//       email,
//       password
//     })
//   }
//   return (
//     <form onSubmit={handleSubmit}>
//       <label>Enter email:
//       <input 
//         type="text" 
//         name="username" 
//         // value={inputs.email || ""} 
//         // onChange={handleSubmit={emailSubmit}}
//       />
//       </label>
//       <label>Enter password:
//         <input 
//           type="number" 
//           name="age" 
//           // value={inputs.age || ""} 
//           // onChange={handleChange}
//         />
//         </label>
//         <input type="submit" />
//     </form>
//   )
// }