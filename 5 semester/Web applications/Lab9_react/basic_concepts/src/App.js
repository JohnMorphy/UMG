import './App.css';
import {useState} from 'react';

function Button(props) 
{
  const [clickedCounter, setClickedCounter] = useState(0);
  
  function handleClick()
  {
    alert("You clicked: " + props.owner)
    setClickedCounter((prevCount)=>prevCount+1)
  }
  
  return <button onClick={handleClick}>
    {props.owner}'s button, clicked: {clickedCounter}
  </button>
}

function Person(props)
{
  return <div className="person">
    <h2>
      Name: {props.name}, Last name: {props.lastName},
      Age: {props.age} {props.age >= 28 ? <> - Old</> : <> - Young</>}
      <br/>
      <Button owner = {props.name}/>
    </h2>
  </div>
}

var people = [
  {name: "Jack", lastName: "Sparrow", age: 27},
  {name: "Geralt", lastName: "Rivia", age: 106},
  {name: "Bruce", lastName: "Wayne", age: 30},
]

var listedPeople = people.map(person=>
    <Person name={person.name} lastName={person.lastName} age={person.age} />
  )

function App() {
  return (
    <div className='greetings'>
      {listedPeople}
    </div>
  );
}

export default App;
