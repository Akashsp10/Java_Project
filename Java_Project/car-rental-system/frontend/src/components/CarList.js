import React, {useEffect, useState} from 'react';
import axios from 'axios';

export default function CarList(){
  const [cars, setCars] = useState([]);
  useEffect(()=>{
    axios.get('http://localhost:8080/api/cars/available')
      .then(r=>setCars(r.data))
      .catch(e=>console.error(e));
  },[]);
  return (
    <div>
      <h2>Available Cars</h2>
      {cars.map(car => (
        <div key={car.id} className="car">
          <b>{car.make} {car.model}</b> — Plate: {car.plate} — ${car.pricePerDay}/day
          <div>
            <button onClick={()=>{
              const name = prompt('Your name');
              const from = prompt('From (YYYY-MM-DD)');
              const to = prompt('To (YYYY-MM-DD)');
              if(!name||!from||!to) return;
              axios.post('http://localhost:8080/api/bookings', {
                carId: car.id,
                customerName: name,
                fromDate: from,
                toDate: to
              }).then(res=>{
                alert('Booked! Total price: ' + res.data.totalPrice);
                window.location.reload();
              }).catch(err=>{ alert('Error: '+ (err.response?.data?.message || err.message))});
            }}>Book</button>
          </div>
        </div>
      ))}
    </div>
  );
}
