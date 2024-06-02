import React, { createContext, useState } from 'react';

export const StudentContext = createContext();

const StudentProvider = ({ children }) => {
  const [students, setStudents] = useState(() => {
    const savedStudents = localStorage.getItem('students');
    return savedStudents ? JSON.parse(savedStudents) : [];
  });

  const addStudent = (student) => {
    const updatedStudents = [...students, student];
    setStudents(updatedStudents);
    localStorage.setItem('students', JSON.stringify(updatedStudents));
  };

  const removeStudent = (id) => {
    const updatedStudents = students.filter(student => student.id !== id);
    setStudents(updatedStudents);
    localStorage.setItem('students', JSON.stringify(updatedStudents));
  };

  return (
    <StudentContext.Provider value={{ students, addStudent, removeStudent }}>
      {children}
    </StudentContext.Provider>
  );
};

export default StudentProvider;
