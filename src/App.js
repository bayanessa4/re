import React from 'react';
import StudentProvider from './Students';
import StudentForm from './Studen2';
import StudentList from './List';
import './App.css';

function App() {
  return (
    <StudentProvider>
      <div className="App">
        <h1>Students</h1>
        <StudentForm />
        <StudentList />
      </div>
    </StudentProvider>
  );
}

export default App;
