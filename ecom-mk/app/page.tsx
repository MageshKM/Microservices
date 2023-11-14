import React from 'react';
import './index.css';
import App from './App';
import HomeView from './components/pages/Home/HomeView';
import OrderForm from './components/pages/Form/OrderForm';
import Tabler from './components/pages/Form/Tabler'

export default function Home() {
  return ( 
 <div><HomeView/>
 <div><OrderForm/></div>
 <div><Tabler/></div>
 </div>
); 
}
