// import logo from './logo.svg';
import yaourt from "./assets/img/yaourtpng.png"
import './App.css';
import FirstComponent from './components/FirstComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={yaourt} className="App-logo" alt="logo" />
        {/* <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        > 
          Learn React
        </a>*/}
        <FirstComponent />
      </header>
    </div>
  );
}

export default App;
