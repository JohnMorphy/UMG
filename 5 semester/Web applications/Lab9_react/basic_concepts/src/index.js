import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import ArtApp from './ArtApp';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ArtApp ids={[2137, 111, 114, 809, 1]} />
  </React.StrictMode>
);
