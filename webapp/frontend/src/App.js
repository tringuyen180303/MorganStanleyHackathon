import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Navbar from './Navbar';
import Home from './Home';
import WishDocu from './WishDocu';
import Community from './Community';
import WishConnect from './WishConnect';
import Resources from './Resources';

const App = () => {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/wishdocu" component={WishDocu} />
        <Route exact path="/community" component={Community} />
        <Route exact path="/wishconnect" component={WishConnect} />
        <Route exact path="/resources" component={Resources} />
      </Switch>
    </Router>
  );
};

export default App;