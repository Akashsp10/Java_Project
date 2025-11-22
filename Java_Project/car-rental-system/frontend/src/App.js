import React from 'react';
import CarList from './components/CarList';
import Admin from './components/Admin';
import './App.css';

export default function App() {
  return (
    <div style={{padding:20}}>
      <h1>Car Rental System</h1>
      <CarList />
      <hr />
      <Admin />
    </div>
  );
}
