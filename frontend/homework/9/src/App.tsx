import './App.css';
import { MainPage } from './main-page/Mainpage';
import { ApiData } from './data/ApiData';

function App() {
    const data = ApiData();
    return (
        <MainPage 
            name={data.name} 
            fullname={data.fullName} 
            qualification={data.qualification} 
            skills={data.skills} 
            hobbies={data.hobbies} 
        />
    );
}

export default App;
