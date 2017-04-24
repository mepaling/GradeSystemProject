package tw.ncu.agile.pair23.GradeSystem;

public class UI {
/**
***************************************************************************************************************
class UI (user interface) 

不斷prompt 使用者 ID. 直到使用者 quit.
check 使用者 ID , 
showWelcomeMsg
    不斷prompt command. 做下列command直到使用者exit
    showGrade, 
    showRank, 
    updateWeights 
    exit

checkID(ID)
promptID()
promptCommand()
showFinishMsg()
showWelcomeMsg()
UI() 建構子 建構 aGradeSystem
***************************************************************************************************************
*/

    public UI() {
    /**
    -----------------------------------------------------------------------------------------------------------
    UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
    -----------------------------------------------------------------------------------------------------------
    */
        int dummy=1; //the object is returned by calling this constructor for unit testing
        try
            1.call GradeSystems() to建構 aGradeSystem

            2.loop1 until Q (Quit)
                  1. promptID() to get user ID  輸入ID或 Q (結束使用)？
                  2. checkID (ID) 看 ID 是否在 aGradeSystem內
                  3. showWelcomeMsg (ID)      ex. Welcome李威廷
                  4. loop2 until E (Exit)
                         promptCommand() to prompt for inputCommand
                     end loop2
              end loop1

            3.showFinishMsg()           結束了
        end try
        finally {}
    }

    public boolean checkID(String id) {
    /**
    -------------------------------------------------------------------------------------------------------------
    checkID(ID) throws NoSuchIDExceptions return Boolean
    parameter: ID   a user ID  ex: 123456789
    time:     O(n)  n is  aGradeSystem 內全班人數
    -------------------------------------------------------------------------------------------------------------
    */
        1. 要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
        2. if not, throw an object of NoSuchIDExceptions
        3. 回傳 true
    }

    public void promptID() {
    /**
    ------------------------------------------------------------------------------------------------------------
    promptID()
    ------------------------------------------------------------------------------------------------------------
    */
        1. prompt user for inputID
        2. if input is "Q" then break
           else assign inputID to userID end if
        
    }
    public void promptCommand() {
    /**
    -------------------------------------------------------------------------------------------------------------
    promptCommand() throws NoSuchCommandExceptions
    -------------------------------------------------------------------------------------------------------------
    */
        1. prompt user for inputCommand
        2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
           throws an object of NoSuchCommandException  end if
        3. if inputCommand is E (Exit) then break
           else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
    }

    public void showWelcomeMsg() {
    /**
    ------------------------------------------------------------------------------------------------------------
    showWelcomeMsg()
    ------------------------------------------------------------------------------------------------------------
    */
        輸出："Welcome "+ userName
    }

    public void showFinishMsg() {
    /**
    ------------------------------------------------------------------------------------------------------------
    showFinishMsg()
    ------------------------------------------------------------------------------------------------------------
    */
        輸出："結束了"
    }
}
