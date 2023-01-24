
import React from 'react'
import { BrowserRouteer, Route, Switch } from 'react-router-dom'
import './App.css';

import Home from './component/Home';
import TopNav from './component/TopNav';
import Login from './component/Login';
import SignUp from './component/SignUp';

function App() {
  const [token, setToken] = useState();

  if(!token){
    return <Login setToken={setToken} />
  }

  return (
    <div className="App">
      <TopNav />
      <Home />
      <BrowserRouter>
        <Switch>
          <Route path="/Home">
            <Home />
          </Route>

          <Route path="/Login">
            <Login />
          </Route>

          <Route path="/SignUp">
            <SignUp />
          </Route>

        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
