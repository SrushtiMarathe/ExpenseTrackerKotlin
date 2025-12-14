import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val expenses = mutableListOf<Expense>()
    var idCounter = 1

    while (true) {
        println("\n=== Expense Tracker ===")
        println("1. Add Expense")
        println("2. View Expenses")
        println("3. Total Expense")
        println("4. Exit")
        print("Choose option: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter title: ")
                scanner.nextLine()
                val title = scanner.nextLine()

                print("Enter amount: ")
                val amount = scanner.nextDouble()

                expenses.add(Expense(idCounter++, title, amount))
                println("Expense added!")
            }

            2 -> {
                if (expenses.isEmpty()) {
                    println("No expenses found.")
                } else {
                    println("\n--- Expense List ---")
                    expenses.forEach {
                        println("ID: ${it.id}, Title: ${it.title}, Amount: ₹${it.amount}")
                    }
                }
            }

            3 -> {
                val total = expenses.sumOf { it.amount }
                println("Total Expense: ₹$total")
            }

            4 -> {
                println("Goodbye!")
                break
            }

            else -> println("Invalid choice!")
        }
    }
}
