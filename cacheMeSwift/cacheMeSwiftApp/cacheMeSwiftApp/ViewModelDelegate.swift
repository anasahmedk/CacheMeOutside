//
//  ViewModelDelegate.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation

// MARK: ViewModelDelegate protocol
protocol ViewModelDelegate: AnyObject {
    func reloadView()
    func show(error: String)
}
