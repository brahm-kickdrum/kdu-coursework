import { HobbyItem } from "./HobbyItem";
import "../main-page-css/HobbyList.css";

export interface IHobbyItem {
    id: number;
    hobby: string;
}

interface HobbyListProps {
    hobbyList: IHobbyItem[];
}

export function HobbyList({ hobbyList }: HobbyListProps) {
    return (

        <div className="hobby-section">
            <h2>Hobbies</h2>
            <ul className="hobby-list">
                {
                    hobbyList.map((hobbyItem) => {
                        return (
                            <HobbyItem hobby={hobbyItem.hobby} />
                        );
                    })
                }
            </ul>

        </div>
    );
}
