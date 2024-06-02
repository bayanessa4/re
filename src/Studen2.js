import React, { useState, useContext } from 'react';
import { StudentContext } from './Students';

const StudentForm = () => {
  const { addStudent } = useContext(StudentContext);
  const [name, setName] = useState('');
  const [score, setScore] = useState('');
  
  const handleSubmit = (e) => {
    e.preventDefault();
    const newStudent = {
      name,
      score: parseInt(score),
      id: Date.now()
    };
    addStudent(newStudent);
    setName('');
    setScore('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="number"
        placeholder="Score"
        value={score}
        onChange={(e) => setScore(e.target.value)}
      />
      <button type="submit">Add Student</button>
    </form>
  );
};

export default StudentForm;
