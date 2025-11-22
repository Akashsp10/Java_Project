import React, {useState, useEffect} from 'react';
import axios from 'axios';

export default function Admin(){
  const [cars, setCars] = useState([]);
  const [form, setForm] = useState({make:'',model:'',plate:'',pricePerDay:0});
  useEffect(()=>{ axios.get('http://localhost:8080/api/cars').then(r=>setCars(r.data)); },[]);
  const add = ()=>{
    axios.post('http://localhost:8080/api/cars', {...form, available:true})
      .then(()=>{ alert('Added'); window.location.reload(); })
      .catch(e=>alert(e));
  };
  
  return (
    <div>
      <h2>Admin</h2>
      <div style={{marginBottom:10}}>
        <input placeholder='Make' onChange={e=>setForm({...form, make:e.target.value})} />
        <input placeholder='Model' onChange={e=>setForm({...form, model:e.target.value})} />
        <input placeholder='Plate' onChange={e=>setForm({...form, plate:e.target.value})} />
        <input type='number' placeholder='Price/day' onChange={e=>setForm({...form, pricePerDay: parseFloat(e.target.value)})} />
        <button onClick={add}>Add Car</button>
      </div>
      <h3>All Cars</h3>
      {cars.map(c=>(
        <div key={c.id} className="car">{c.make} {c.model} — {c.plate} — ${c.pricePerDay} — {c.available ? 'Available':'Booked'}</div>
      ))}
    </div>
  );
}
