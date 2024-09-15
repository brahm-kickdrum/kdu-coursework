import { ISkillItem } from "./SkillList";
import { IHobbyItem } from "./HobbyList";
import { SkillList } from "./SkillList";
import { HobbyList } from "./HobbyList";
import { Name } from "./Name";
import { FullName } from "./FullName";
import { Qualification } from "./Qualifications";
import "../main-page-css/Mainpage.css";

interface IApiData {
    name: string,
    fullname: string,
    qualification: string,
    skills: ISkillItem[],
    hobbies: IHobbyItem[]
}

export function MainPage({ name, fullname, qualification, skills, hobbies }: IApiData) {
    return (

        <div className="main-page">
            <Name name={name} />
            <FullName fullname={fullname} />
            <Qualification qualification={qualification} />
            <div className="lists">
                <SkillList skillList={skills} />
                <HobbyList hobbyList={hobbies} />
            </div>
        </div>
    );
}