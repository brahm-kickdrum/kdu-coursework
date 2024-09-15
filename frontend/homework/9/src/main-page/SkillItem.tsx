import "../main-page-css/SkillItem.css"

interface SkillItemProps{
    skill: string;
}

export function SkillItem({skill}:SkillItemProps){
    return(
        <li className="skill-item">{skill}</li>
    );
}