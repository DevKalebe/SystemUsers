import { useState } from "react";
import {defaultTheme} from "./styles/themes/default"
import { ThemeProvider } from "styled-components";
import { GlobalStyle } from "./styles/global";

function App() {
  return (
    <ThemeProvider theme={defaultTheme}>
      <GlobalStyle />
    </ThemeProvider>
  );
}

export default App;
