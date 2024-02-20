import "./ListItem.scss"

interface IListItem {
  text: string;
  id: string;
  onRemove: (id: string) => void;
}

export function ListItem({ text, id, onRemove }: IListItem) {
  const handleRemove = () => {
    onRemove(id);
  };
  return (
    <div className="items">
      <li className="list-item">{text}</li>
      <button onClick={handleRemove}>
        <img src="remove.png" alt="x"/>
      </button>
    </div>
  )
}
