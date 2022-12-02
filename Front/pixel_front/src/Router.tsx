import React from 'react';
import { Routes, Route } from "react-router-dom";
import { home } from './Pages/home';
import { listUsers } from './Pages/listUsers';
import { registrationUser } from './Pages/registrationUser';

export function Router() {
  return (
    <Routes>
      <Route path='/' element={home}/>
      <Route path='/listUser' element={listUsers}/>
      <Route path='registerUser' element={registrationUser}/>
    </Routes>
  );
}