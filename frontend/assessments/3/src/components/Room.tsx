import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/store";
import { fetchRoomData } from "../redux/thunk/getRooms";
import { selectRoom } from "../redux/RoomsSlice";
import { clearSelectedAddOns, deselectAddOn, selectAddOn } from "../redux/thunk/AddonsSlice";



export const Room: React.FC = () => {


    const style: { [key: string]: React.CSSProperties } = {
        mainPage: {
            margin: " 0 10%"
        },
        hotelBooking: {
            margin: "2rem 0",
            textAlign: "center",
            fontSize: "3rem",
            fontWeight: "300",
        },
        h2: {
            backgroundColor: "#F08A5D",
            color: "white",
            height: "3.5rem",
            display: "flex",
            alignItems: "center",
            padding: "0 1rem",
            fontSize: "1rem",
            fontWeight: "400"
        },
        roomList: {
            margin: "0 0 4rem 0"
        },
        calander: {
            width: "15rem",
            padding: "0.5rem 0",
            margin: "0.5rem 0.5rem 0 0",
            height: "2rem"
        },
        dateSection: {
            margin: "0 0 4rem 0"
        },
        addOnsSection: {
            margin: "0 0 4rem 0",
        },
        addOns:{
            display:"flex",
            flexWrap: "wrap",
            color: "red"
        },
    }

    const dispatch: AppDispatch = useDispatch();
    const { rooms, selectedRoomId } = useSelector((state: RootState) => state.roomData);
    const [startDate, setStartDate] = useState(new Date('2001-01-01'));
    const [endDate, setEndDate] = useState(new Date('2001-01-01'));
    const selectedAddOns = useSelector((state: RootState) => state.selectedAddOns.selectedAddOns);
    const [totalCost, setTotalCost] = useState<number>(0);

    useEffect(() => {
        dispatch(fetchRoomData());
        console.log(rooms);
    }, []);

    const handleRoomSelect = (roomId: number) => {
        dispatch(selectRoom(roomId));
        dispatch(clearSelectedAddOns());
    };

    const handleAddOnSelect = (addOnName: string) => {
        if (selectedAddOns.includes(addOnName)) {
            dispatch(deselectAddOn(addOnName));
        } else {
            dispatch(selectAddOn(addOnName));
        }
    };

    const handleCalculateCost = () => {
        const selectedRoom = rooms.find(room => room.id === selectedRoomId);
        if (!selectedRoom) return;

        let roomCost = Number(selectedRoom.costPerNight);

        let addOnsCost = selectedAddOns.reduce((acc, addOnName) => {
            const addOn = selectedRoom.addOns.find(addOn => addOn.name === addOnName);
            if (addOn) {
                acc += Number(addOn.cost);
            }
            return acc;
        }, 0);

        const numberOfDays = Math.ceil((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));

        let cost: number = (roomCost + addOnsCost) * numberOfDays;
        cost = cost * 1.18;
        setTotalCost(cost);
    };

    useEffect(() => {
        handleCalculateCost();
    }, [selectedRoomId, startDate, endDate, selectedAddOns])

    console.log("rooms:", rooms, typeof rooms)
    return (
        <div style={style.mainPage}>

            <h1 style={style.hotelBooking}>Hotel Booking</h1>
            {/* Section 1: Room Section */}
            <section>
                <h2 style={style.h2}>
                    <p>
                        Select Room Type
                    </p>
                </h2>
                <ul style={style.roomList}>
                    {
                        rooms.map((room) => {
                            return (
                                <button key={room.id} onClick={() => handleRoomSelect(room.id)}
                                    style={{
                                        color: selectedRoomId === room.id ? '#F08A5D' : 'black',
                                        cursor: 'pointer',
                                        backgroundColor: "white",
                                        borderColor: selectedRoomId === room.id ? '#F08A5D' : 'black',
                                        borderWidth: "1px",
                                        padding: "1.5rem",
                                        margin: "0.5rem 0.5rem 0 0",
                                        width: "15rem",

                                    }
                                    }>
                                    {room.name}
                                </button>
                            );
                        })
                    }
                </ul>
            </section>


            {/* Section 2: Date Section */}
            <section style={style.dateSection}>
                <h2 style={style.h2}>
                    <p>
                        Select Date
                    </p>
                </h2>
                <input style={style.calander} type="date" value={startDate ? startDate.toISOString().slice(0, 10) : ''} onChange={(e) => setStartDate(new Date(e.target.value))} />
                <input style={style.calander} type="date" value={endDate ? endDate.toISOString().slice(0, 10) : ''} onChange={(e) => setEndDate(new Date(e.target.value))} />
            </section>


            {/* Section 3: Add-ons Section */}
            <section style={style.addOnsSection}>
                <h2 style={style.h2}>
                    <p>
                        Add-ons Selection
                    </p>
                </h2>
                {selectedRoomId !== 0 && (
                    <div>
                        {rooms.find(room => room.id === selectedRoomId)?.addOns.map(addOn => (
                            <div style={style.addOns} key={addOn.name}>
                                <button
                                    onClick={() => handleAddOnSelect(addOn.name)}
                                    style={{
                                        // backgroundColor: selectedAddOns.includes(addOn.name) ? '#F08A5D' : 'black',
                                      

                                        color: selectedAddOns.includes(addOn.name) ? '#F08A5D' : 'black',
                                        cursor: 'pointer',
                                        backgroundColor: "white",
                                        borderColor: selectedAddOns.includes(addOn.name) ? '#F08A5D' : 'black',
                                        borderWidth: "1px",
                                        padding: "1.5rem",
                                        margin: "0.5rem 0.5rem 0 0",
                                        width: "15rem",
                                    }}
                                >
                                    {/* {addOn.name} - ${addOn.cost} */}
                                    {addOn.name}
                                </button>
                            </div>
                        ))}
                    </div>
                )}
            </section>

            {/* Section 4: Total Cost Section*/}
            <section>
                {/* <button onClick={handleCalculateCost}>Calculate Total Cost</button> */}
                <p>Total Cost: {totalCost}</p>
            </section>

            <button 
            style={{
                backgroundColor: selectedRoomId && (Math.ceil((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24)))? '#F08A5D' : 'white',
                cursor: 'pointer',
                borderColor: selectedRoomId && (Math.ceil((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24)))? 'white' : 'black',
                color: selectedRoomId && (Math.ceil((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24))) ? 'white' : 'black',
                borderWidth: "1px",
                padding: "1.5rem",
                margin: "0.5rem 0.5rem 0 0",
                width: "15rem",

            }
            }>Submit</button>


        </div>
    );
};
