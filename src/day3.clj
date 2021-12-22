(ns day3
  (:require
    [clojure.string :as string]
    ))

(def day-input
  (->> (slurp "src/day3")
       (string/split-lines)
       (map #(re-seq #"\d" %))))


(defn day3-task-parse-to-int [input]
  (reduce
    (fn [x coll]
      (->> coll
          (map #(Integer/parseInt %))
           (conj x)))
    [] input))



(defn da3-task [input]
  (reduce
    (fn [res coll]
      (if (= coll 0)
       (update res :zero inc)
       (update res :ones inc)))
    {:ones 0 :zero 0} input))



;(defn da3-task [input]
; (apply mapv vector input)
;  (reduce
;    (fn [res coll]
;      (if (= coll 0)
;        (update res :zero inc)
;        (update res :ones inc)))
;    {:ones 0 :zero 0} input))





(defn transpose [m]
  (apply mapv vector m))



(defn result-task [input]
  (reduce
    (fn [x coll]
      (->> coll
          (da3-task)
          (conj x)))
    [] input))





(defn x-result [input]
  (->> input
     (day3-task-parse-to-int)
     (transpose)
     (result-task)
     (map (fn [{:keys [ones zero]}]
            (if (> ones zero) 1 0)))))

(defn y-result [x-result]
  (if (= x-result 0) 1 0))


(defn result [input]
  (let [x (x-result input )
        y (map y-result x)]
    (*
      (Long/parseLong (string/join x) 2)
      (Long/parseLong (string/join y) 2)
      )))

(defn day3-task2 [input]
  (loop [coll input]
    (if (> (count coll) 1)
      (

        ))

    ))





(day3-task2 day-input )
(comment

  (count [[0 1 0 0 0 1 1 1 0 0 1 1]
          [1 0 0 0 0 1 0 0 1 1 1 1]
          [1 1 0 1 0 1 0 1 0 0 0 0]
          [100001100010]
          [000011000100]])



(> 1 1)

(result day-input)
  )
