import {SkillItem} from "./SkillItem";
import "../main-page-css/SkillList.css"

export interface ISkillItem{
    id: number;
    skill: string
}

interface SkillListProps{ 
    skillList : ISkillItem[];
}

export function SkillList({skillList}:SkillListProps){
    return(
        
        <div className="skill-section">
        <h2>Skills</h2>
        <ul className="skill-list">
            {
                skillList.map((skillItem)=>{
                    return(
                        <SkillItem skill={skillItem.skill} />
                    );
                })
            }
        </ul>
        </div>
                
    );
}
