import '../main-page-css/HobbyItem.css';

interface ListItemProps{
    hobby: string;
}

export function HobbyItem({hobby}:ListItemProps){
    return(
        <li className="hobby-item">{hobby}</li>
    )
}