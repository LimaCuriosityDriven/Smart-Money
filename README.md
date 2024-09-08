# SmartMoney

SmartMoney is a personal finance organizer currently in development. It aims to help users manage their finances effectively by providing tools to:

- **Track Expenses 💸:** Record and categorize all expenses to gain a clear understanding of spending habits.
- **Manage Income 💰:** Add and monitor various sources of income to keep an overview of earnings and financial growth.
- **Monitor Investments 📈:** Keep track of investments, including their performance and returns, to make informed financial decisions.


## 🛠 Used technologies
- **Java**
- **MySQL**
- **JavaServlet**
- **HTML**
- **Bootstrap**
<div>
  <img src="https://www.svgrepo.com/show/452234/java.svg" alt="Java Logo" width="25"/>
  <img src="https://www.svgrepo.com/show/452045/js.svg" alt="JSLogo" width="25"/>
  <img src="https://www.svgrepo.com/show/452228/html-5.svg" alt="HTML Logo" width="25"/>
  <img src="https://www.svgrepo.com/show/353498/bootstrap.svg" alt="Bootstrap" width="25"/>
</div>

## SQL Schema

Here is the SQL schema for the tables used in the SmartMoney project:

```sql
CREATE DATABASE fintech;

CREATE TABLE t_fin_recebimentos (
    id_recebimento INT AUTO_INCREMENT PRIMARY KEY,
    nm_recebimento VARCHAR(255) NOT NULL,
    vl_recebimento FLOAT NOT NULL,
    dt_recebimento DATE NOT NULL,
    st_recebimento INT NOT NULL,
    ds_recebimento VARCHAR(500)
);

CREATE TABLE t_fin_investimentos (
    id_investimento INT AUTO_INCREMENT PRIMARY KEY,
    nm_investimento VARCHAR(255) NOT NULL,
    vl_investimento DOUBLE NOT NULL,
    dt_investimento DATE NOT NULL,
    vl_retorno_mes DOUBLE NOT NULL
);

CREATE TABLE t_fin_despesas (
    id_despesa INT AUTO_INCREMENT PRIMARY KEY,
    nm_despesa VARCHAR(255) NOT NULL,
    vl_despesa FLOAT NOT NULL,
    dt_despesa DATE NOT NULL,
    dt_vencimento DATE NOT NULL,
    st_despesa INT NOT NULL,
    ds_despesa VARCHAR(500)
);
