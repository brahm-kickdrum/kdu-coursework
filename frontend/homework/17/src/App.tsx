import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getProducts } from "./redux/thunk/getProducts";
import { AppDispatch, RootState } from "./redux/store";
import Loader from "./components/Loader";
import { TransitionsSnackbar } from "./components/Snackbar";

function App() {
  const reduxDispatch: AppDispatch = useDispatch();

  useEffect(() => {
    reduxDispatch(getProducts());
  }, []);

  const productList = useSelector((state: RootState) => state.productList.productList);
  const status = useSelector((state: RootState) => state.productList.status);
  const show = useSelector((state: RootState) => state.snackBar.show);

  const style : { [key: string]: React.CSSProperties }={
    mainpage: {
      display: "flex",
      justifyContent: "space-around",
      flexDirection: "column",
      alignItems: "center",
      width: "100vw",
      backgroundColor: "#EEEEEE"
    },
    header:{
      display: "flex",
      justifyContent: "center",
      padding: "2rem",
      fontSize: "3rem"
    },
    marketplace:{
      paddingLeft: "1rem",
      color: "blue"
    },
    productList:{
      display: "flex",
      width: "100%",
      flexWrap: "wrap",
      justifyContent: "space-around"
    },
    listItem:{
      margin: "1.5rem",
      backgroundColor: "white",
      width: "22%",
      height: "20rem",
      display: "flex",
      justifyContent: "center",
      flexDirection: "column",
      alignContent: "center"
    },
    imageDiv: {
      display: "flex",
      justifyContent: "center",
      backgroundColor: "white",
      padding:"3rem 1rem"
    },
    listImage:{
      width: "40%",
      height: "10rem",
    },
    titlePriceDiv:{
      display: "flex",
      justifyContent: "space-around",
      padding: "2rem 1rem"
    },
    title:{
      width: "80%",
    },
    price:{
      width: "10%",
    }

  }

  return (
    <>
      {status === "pending" ? (
        <Loader />
      ) : (
        <div style={style.mainpage}>
          <div style = {style.header}>
            <h1>KDU </h1>
            <h1 style={style.marketplace}>MARKETPLACE</h1>
          </div>
          <ul style = {style.productList}>
            {productList.map((productItem) => {
              return (
                <li style={style.listItem} key={productItem.id}>
                  <div style={style.imageDiv}>
                    <img style={style.listImage} src={productItem.image} alt="product" />
                  </div>
                  <div style={style.titlePriceDiv}>
                    <div style={style.title}>
                      {productItem.title}
                    </div>
                    <div style={style.price}>
                      {productItem.price}
                    </div>
                  </div>
                </li>
              );
            })}
          </ul>
        </div>
      )}

      {
        show && (
          <TransitionsSnackbar />
        )
      }

    </>
  );
}

export default App;
