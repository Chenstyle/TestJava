package com.datachina.ktlib.exercise3

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.Action
import javax.swing.JButton
import javax.swing.JFrame

/**
 *
 */
fun main() {
    val jFrame = JFrame("My JFrame")
    val jButton = JButton("My JButton")
    jFrame.addWindowListener(object : WindowListener {
        override fun windowOpened(e: WindowEvent?) {
            println("windowOpened")
        }

        override fun windowClosing(e: WindowEvent?) {
            println("windowClosing")
        }

        override fun windowClosed(e: WindowEvent?) {
        }

        override fun windowIconified(e: WindowEvent?) {
        }

        override fun windowDeiconified(e: WindowEvent?) {
        }

        override fun windowActivated(e: WindowEvent?) {
            println("windowActivated")
        }

        override fun windowDeactivated(e: WindowEvent?) {
        }

    })

//    jButton.addActionListener(object : ActionListener {
//        override fun actionPerformed(e: ActionEvent?) {
//            println("Button Pressed")
//        }
//    })

//    jButton.addActionListener(ActionListener {
//        println("Button Pressed")
//    })

    jButton.addActionListener {
        println("Button Pressed")
    }

    val listener = ActionListener { println("hello world")}
    println(listener.javaClass)
    println(listener.javaClass.superclass)

    println(listener::class)
    println(listener::class.java)

    jFrame.add(jButton)
    jFrame.pack()
    jFrame.isVisible = true
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

}